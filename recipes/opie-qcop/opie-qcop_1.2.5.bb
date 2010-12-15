require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_apps_qcop.tar.bz2;name=split_core_apps_qcop \
           file://unbreak-logging.patch"
SRC_URI[split_core_apps_qcop.md5sum] = "9afc33ac0e5205de5008bf13b22117b2"
SRC_URI[split_core_apps_qcop.sha256sum] = "59cf36bb4c192a36855819771eb3d986588b4c786f799b232b01bc33c0377516"
