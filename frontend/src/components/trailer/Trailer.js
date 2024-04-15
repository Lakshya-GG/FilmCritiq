import React from 'react';
import { useParams } from 'react-router-dom';
import ReactPlayer from 'react-player';
import './Trailer.css';

const Trailer = () => {
  let params = useParams();
  let key = params.ytTrailerId;
  console.log("YouTube Trailer ID:", key);

  // Log the YouTube Trailer ID to the console to ensure it's being received correctly
  console.log("YouTube Trailer ID:", key);

  return (
    <div className="react-player-container">
      {key ? (
        <ReactPlayer
          controls={true}  // Correctly set controls as a boolean
          playing={true}   // This will auto-play the video
          url={`https://www.youtube.com/watch?v=${key}`}
        />
      ) : (
        <p>No trailer key provided!</p>  // Display a message if no key is found
      )}
    </div>
  );
}

export default Trailer;
