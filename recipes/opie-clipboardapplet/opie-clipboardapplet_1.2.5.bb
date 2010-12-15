require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_applets_clipboardapplet.tar.bz2;name=split_core_applets_clipboardapplet \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_clipboardapplet.md5sum] = "62ce49c0eeea827260247c89c2e4b338"
SRC_URI[split_core_applets_clipboardapplet.sha256sum] = "1a785f1e87f1b7d1a909adbe97aa0aad7e8ba46b285c4d506216c57dd0ddba05"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
