import React, { Component } from "react";

class DropdownCountries extends Component {
  constructor() {
    super();

    this.state = {
      options: [],
      value: "",
    };

    this.onChange = this.onChange.bind(this);
  }

  componentDidMount() {
    fetch("http://localhost:8080/api/stats/countries", {
      method: "GET",
    })
      .then((res) => res.json())
      .then((jsonData) => {
        this.setState({ options: jsonData, value: jsonData[0].id });
        // console.log(jsonData);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  componentDidUpdate() {
    if (this.props.onChange) {
      this.props.onChange(this.state.value);
    }
  }

  onChange(e) {
    this.setState({ value: e.target.value });
    console.log("Select value changed to", e.target.value);
  }

  render() {
    // console.log("This is DropdownTest", this.props);
    return (
      <div>
        <label>Select country:</label>
        <br />
        <select value={this.state.value} onChange={this.onChange}>
          {this.state.options.map((item) => (
            <option key={item.id} value={item.id}>
              {item.name}
            </option>
          ))}
        </select>
      </div>
    );
  }
}

export default DropdownCountries;
