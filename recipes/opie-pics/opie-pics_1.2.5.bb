require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_pics-hires.tar.bz2;name=split_pics-hires"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_pics-hires.md5sum] = "f8f895e7136ebd0a514166a184dec0bd"
SRC_URI[split_pics-hires.sha256sum] = "04871cc3cfe0c4f9f6dc3f19b1e8fa4ce16412295137414d33c4af372f12111e"
