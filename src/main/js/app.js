const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {tracks: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/tracks'}).done(response => {
            this.setState({tracks: response.entity._embedded.tracks});
    });
    }

    render() {
        return (
            <TrackList tracks={this.state.tracks}/>
    )
    }
}

class TrackList extends React.Component{
    render() {
        var tracks = this.props.tracks.map(track =>
            <Track key={track._links.self.href} track={track}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                </tr>
                {tracks}
                </tbody>
            </table>
        )
    }
}

class Track extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.track.name}</td>
                <td>{this.props.track.description}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)