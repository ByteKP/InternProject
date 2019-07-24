import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import CreateProjectButton from "./Project/CreateProjectButton";
import { connect } from "react-redux";
import { getProjects } from "../actions/projectActions";
import PropTypes from "prop-types";

class Dashboard extends Component {
  //2nd. The comp can now uses getProjects dispatch method
  //to in turn dispatch GET_PROJECTS with payload to the projectReducers
  //the projectReducers then destructure the payload to its state
  componentDidMount() {
    this.props.getProjects();
  }
  render() {
    //4th. the comp can now use completed reducer's state
    //through destructuring in its render()
    const { projects } = this.props.project;
    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Projects</h1>
              <br />
              <CreateProjectButton />
              <br />
              <hr />
              {projects.map(project => (
                <ProjectItem key={project.id} project={project} />
              ))}
            </div>
          </div>
        </div>
      </div>
    );
  }
}
Dashboard.propTypes = {
  project: PropTypes.object.isRequired
};

//3rd. Map projectReducers' new state after destructure to
//the comp props
const mapStateToProps = state => ({
  project: state.project
});

//1st step. The comp connects to redux store and
//map both state(initial) and dispatch method(getProjects) to the comp's props
export default connect(
  mapStateToProps,
  { getProjects }
)(Dashboard);
