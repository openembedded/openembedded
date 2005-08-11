include ctorrent.inc
PR = "r4"

SRC_URI += "file://configure.patch;patch=1 \
	    file://align.patch;patch=1 \
	    file://nogetwd.patch;patch=1 \
	    file://crash.patch;patch=1 \
	    file://fmt.patch;patch=1 \
	    file://stall.patch;patch=1 \
	    file://tracker.patch;patch=1 \
	    file://passkey.patch;patch=1"
