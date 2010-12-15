require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_applets_vmemo.tar.bz2;name=split_core_applets_vmemo \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_vmemo.md5sum] = "9fd1ee93874f300c21ece152984583de"
SRC_URI[split_core_applets_vmemo.sha256sum] = "567fe3ebf2fcd98389706ec67a54f52bdc9b5b429f48963c1dc411c95f0285ac"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"

DEPENDS = "libopiecore2 libopieui2 libopiemm2"
