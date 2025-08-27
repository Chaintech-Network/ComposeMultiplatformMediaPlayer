// shaka-global.js
window.createShakaPlayer = function(mediaElement) {
    return new shaka.Player(mediaElement);
};
