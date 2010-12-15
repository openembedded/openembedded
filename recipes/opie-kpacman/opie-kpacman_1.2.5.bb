require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_games_kpacman.tar.bz2;name=split_noncore_games_kpacman \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_share.tar.bz2;name=split_share \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_noncore_games_kpacman.md5sum] = "b37cee9d490c4a3e032dd691c5d360fd"
SRC_URI[split_noncore_games_kpacman.sha256sum] = "ab6909f713e489f51a87bc0965febc27e3753e3d3b94f85bfc8dbc4cdec57165"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_share.md5sum] = "a715ae54405cae2b17c35d166f161aa8"
SRC_URI[split_share.sha256sum] = "0b71c8726b41f8c4dfd3a31fbb23f9c533c16d7d9c1f3002ab0d2daea274da7a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
