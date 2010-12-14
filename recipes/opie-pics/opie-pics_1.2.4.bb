require ${PN}.inc

PR = "r1"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_pics-hires.tar.bz2;name=split_pics-hires"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_pics-hires.md5sum] = "0a19e0f20e875e97c37ee45c971591a7"
SRC_URI[split_pics-hires.sha256sum] = "38c7095b9304127ba8b52a76ce3e01d854c9d3d78a752c675ea533a0dac24029"
