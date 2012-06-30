require bluez4.inc

SRC_URI += "file://sbc-thumb.patch"

DEPENDS += "libsndfile1"
PR = "${INC_PR}.1"

inherit update-rc.d

INITSCRIPT_NAME = "bluetooth"
INITSCRIPT_PARAMS = "defaults 23 19"

SRC_URI[md5sum] = "a44181c8cf79796a99b792a5372e602d"
SRC_URI[sha256sum] = "a834f3a961449c6ae83ad26aa5d0b82a6cdd7e49f608aa71a2454a33c62cfb99"
