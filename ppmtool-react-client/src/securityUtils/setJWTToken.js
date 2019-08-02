import axios from "axios";

const setJWTToken = token => {
  if (token) {
    axios.setdefaults.headers.common["Authorization"] = token;
  } else {
    delete axios.setdefaults.headers.common["Authorization"];
  }
};

export default setJWTToken;
