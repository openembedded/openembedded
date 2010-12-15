require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_applets_memoryapplet.tar.bz2;name=split_noncore_applets_memoryapplet \
           http://sources.openembedded.org/opie-1.2.5-split_noncore_settings_sysinfo.tar.bz2;name=split_noncore_settings_sysinfo \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_applets_memoryapplet.md5sum] = "4ca6be68c3026bd1de9e1ccf2d8f5eeb"
SRC_URI[split_noncore_applets_memoryapplet.sha256sum] = "79a978cbc6929c020a285bb854c3e929ea4e73f3c87db19330241368c430ff59"
SRC_URI[split_noncore_settings_sysinfo.md5sum] = "a451202461d0b467568b5b076c502e73"
SRC_URI[split_noncore_settings_sysinfo.sha256sum] = "6704ae28eaf824e2e8338eaf49981761fbab60dde4f4ddeb829baf99a9dc3808"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
