require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_examples.tar.bz2;name=split_examples \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_examples.md5sum] = "9e6a0e76e883a27cc1fcb8f3df3c844e"
SRC_URI[split_examples.sha256sum] = "73547a40fc8a0cea3561ec5402341cc49c857111df1af5217d7fb02d407e1e88"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
