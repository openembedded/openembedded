require ${PN}.inc

PR = "r1"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_sounds.tar.bz2;name=split_sounds"
SRC_URI[split_sounds.md5sum] = "eab6336ddc7a8b4db9fca94cef2485b1"
SRC_URI[split_sounds.sha256sum] = "a110602cd5013c6a406765f351a8484478617b2002377dd3c02a8bf450ca845f"
