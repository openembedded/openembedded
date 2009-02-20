require apt-native.inc

SRC_URI += "file://nodoc.patch;patch=1 \
            file://noconfigure.patch;patch=1 \
	    file://no-curl.patch;patch=1"
