require apt-native.inc
PR = "r1"

SRC_URI += "file://nodoc.patch;patch=1 \
            file://noconfigure.patch;patch=1 \
	    file://no-curl.patch;patch=1"

SRC_URI[md5sum] = "e6ee1b594f6ed5fab5cb593ee46cfc21"
SRC_URI[sha256sum] = "4dc935a520c65705795ada5942b658f6e86b22eefc7032342267272bd6566b05"
