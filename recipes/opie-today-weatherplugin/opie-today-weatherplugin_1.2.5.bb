require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_todayplugins_weather.tar.bz2;name=split_noncore_todayplugins_weather \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_todayplugins_weather.md5sum] = "4900e1091a1473ef6d8b722ff1cbfb6a"
SRC_URI[split_noncore_todayplugins_weather.sha256sum] = "990e2ef1ae38ca427abc4c466840ce183c637cb90587f971767b781be5dfebc4"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
