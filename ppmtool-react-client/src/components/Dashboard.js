import React, { Component } from 'react'
import ProjectItem from './project/ProjectItem'
import "bootstrap/dist/css/bootstrap.min.css";
import CreateProjectButton from './project/CreateProjectButton';
import { connect } from 'react-redux';
import { getProjects } from '../actions/projectActions';
import { PropTypes } from 'prop-types';
class Dashboard extends Component {

  componentDidMount() {
    this.props.getProjects();
  }

  render() {
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
                    {projects?  projects.map(project => (
                        <ProjectItem key={project.id} project={project} />
                    )) : null}
                </div>
            </div>
        </div>
    </div>

    )
  }
}

Dashboard.propTypes = {
  getProjects: PropTypes.func.isRequired,
  project: PropTypes.object.isRequired
}

const mapStateToProps = state => ({
  project: state.project
});



export default connect(mapStateToProps, {getProjects})  (Dashboard);
