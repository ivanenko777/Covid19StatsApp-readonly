import React, { Component } from "react";
import { Line, defaults } from "react-chartjs-2";
import { merge } from "lodash";

defaults.global.legend.position = "right";

const chart_config = {
  datasets: [
    {
      backgroundColor: "rgba(0, 0, 0, 0.0)",
      borderColor: "rgba(255, 99, 132, 1)",
    },
    {
      backgroundColor: "rgba(0, 0, 0, 0.0)",
      borderColor: "rgba(54, 162, 235, 1)",
    },
  ],
};

class LineChart extends Component {
  constructor() {
    super();

    this.state = {
      country_id: "1",
      data: {
        datasets: [],
        labels: [],
      },
    };
  }

  componentDidUpdate(prevProps) {
    if (prevProps && this.state.country_id !== this.props.selected_value) {
      this.setState({ country_id: this.props.selected_value });
      this.loadData();
    }
  }

  loadData() {
    if (this.state.country_id) {
      fetch("http://localhost:8080/api/stats/" + this.props.selected_value, {
        method: "GET",
      })
        .then((res) => res.json())
        .then((jsonData) => {
          this.setState({ data: merge(jsonData, chart_config) });
          //   console.log(jsonData);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }

  render() {
    return (
      <div className="chart-container">
        <Line
          data={this.state.data}
          options={{
            // resposive: true,
            // maintainAspectRatio: false,
            title: {
              display: this.state.data.country,
              text: this.state.data.country,
              fontSize: 24,
            },
            scales: {
              xAxes: [
                {
                  display: this.state.data.country,
                  scaleLabel: {
                    display: true,
                    labelString: "Year - Week",
                    fontSize: 14,
                  },
                },
              ],
              yAxes: [
                {
                  display: this.state.data.country,
                  scaleLabel: {
                    display: true,
                    labelString: "Count",
                    fontSize: 14,
                  },
                  ticks: {
                    beginAtZero: true,
                    min: 0,
                  },
                },
              ],
            },
          }}
        />
      </div>
    );
  }
}

export default LineChart;
