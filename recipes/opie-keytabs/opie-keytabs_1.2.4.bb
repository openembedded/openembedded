require ${PN}.inc

PR = "r1"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_etc.tar.bz2;name=split_etc"
SRC_URI[split_etc.md5sum] = "ed2c78e9ce1525da1f4e262528956fb8"
SRC_URI[split_etc.sha256sum] = "ca2819a56531086ec917f7cd560b8a395dd9c2b10dd996adad5deb64fcd3a537"
