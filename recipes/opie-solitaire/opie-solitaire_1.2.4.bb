require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_games_solitaire.tar.bz2;name=split_noncore_games_solitaire \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_noncore_games_solitaire.md5sum] = "b97d398cef20f33255f81d78a4485a84"
SRC_URI[split_noncore_games_solitaire.sha256sum] = "394a04d7bc9c5952ebc3b3b8b3541a6ba3bb34c2af4d4f61811eb206294bb9d3"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
