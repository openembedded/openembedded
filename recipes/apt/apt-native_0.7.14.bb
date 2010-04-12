require apt-native.inc
PR = "r3"

SRC_URI += "file://nodoc.patch;patch=1 \
            file://noconfigure.patch;patch=1 \
	    file://no-curl.patch;patch=1"

SRC_URI[md5sum] = "19efa18fb1ef20c58b9b44e94258b814"
SRC_URI[sha256sum] = "8fc06effaf8a4e4333308eedcdc6840f1c8056f2e924210f151dfc076bcd4045"
