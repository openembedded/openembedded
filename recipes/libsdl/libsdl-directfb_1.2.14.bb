require libsdl-1.2.14.inc

PR = "${INC_PR}.1"

DEPENDS += "directfb"

EXTRA_OECONF = " \
        --disable-arts \
        --disable-diskaudio \
        --disable-esd \
        --disable-esd-shared \
        --disable-esdtest \
        --enable-input-events \
        --disable-input-tslib \
        --disable-mintaudio \
        --disable-nas \
        --disable-nasm \
        --disable-video-dga \
        --disable-video-dummy \
        --enable-video-directfb \
        --enable-video-fbcon \
        --disable-video-opengl \
        --disable-video-picogui \
        --disable-video-ps2gs \
        --disable-video-ps3 \
        --disable-video-qtopia \
        --disable-video-x11 \
"
