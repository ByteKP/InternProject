import { combineReducers } from "redux";
import errorReducers from "./errorReducers";

export default combineReducers({
  errors: errorReducers
});
