require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_applets_brightnessapplet.tar.bz2;name=split_noncore_applets_brightnessapplet \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_applets_brightnessapplet.md5sum] = "1145cb6ddea61510c3528749dfef5d03"
SRC_URI[split_noncore_applets_brightnessapplet.sha256sum] = "9500bd07da0ef75978bf694012d283a9d527f77b42fc60cea78b6ddd23322e3f"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
