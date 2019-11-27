<div id="nowPlayingBarContainer">

    <div id="nowPlayingBar">

        <div id="nowPlayingLeft">
                <div class="content">
                    <span class="albumLink">
                    <img src="<?php echo getArtworkPath($con, $albumId); ?>" class="albumArtwork">
                        
                    </span>

                    <div class="trackInfo">
                        <span class="trackName">
                            <span><?php echo $albumSong->getTitle()?></span>
                        </span>

                        <span class="artistName">
                            <span><?php echo getArtistName($con, $albumId); ?></span>
                        </span>
                    </div>

                </div>
        </div>

        <div id="nowPlayingCenter">

                <div class="content playerControls">

                    <div class="buttons">
                        <button class="controlButton shuffle" title="Shuffle button">
                            <img src="resource/images/icons/shuffle.png" alt="Shuffle">
                        </button>
                        <button class="controlButton previous" title="Previous button">
                            <img src="resource/images/icons/previous.png" alt="Previous">
                        </button>
                        <button class="controlButton play" title="Play button">
                            <img src="resource/images/icons/play.png" alt="Play">
                        </button>
                        <button class="controlButton pause" title="Pause button" style="display: none;">
                            <img src="resource/images/icons/pause.png" alt="Pause">
                        </button>
                        <button class="controlButton next" title="Next button">
                            <img src="resource/images/icons/next.png" alt="Next">
                        </button>
                        <button class="controlButton repeat" title="Repeat button">
                            <img src="resource/images/icons/repeat.png" alt="Repeat">
                        </button>
                    </div>


                    <div class="playbackBar">
                        <span class="progressTime current">0.00</span>
                        <div class="progressBar">
                            <div class="progressBarBg">
                                <div class="progress"></div>
                            </div>
                        </div>
                        <span class="progressTime remaining">0.00</span>
                    </div>

            </div>


        </div>

        <div id="nowPlayingRight">
                <div class="volumeBar">

                    <button class="controlButton volume" title="Volume button">
                        <img src="resource/images/icons/volume.png" alt="Volume">
                    </button>

                    <div class="progressBar">
                        <div class="progressBarBg">
                            <div class="progress"></div>
                        </div>
                    </div>

                </div>
        </div>




    </div>

</div>