require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_todayplugins_weather.tar.bz2;name=split_noncore_todayplugins_weather \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_todayplugins_weather.md5sum] = "24c9beb00058fca1d7b303639ab34716"
SRC_URI[split_noncore_todayplugins_weather.sha256sum] = "e150dc2c3e0ce603f5e198ba0661850c94052df257cd7dbc553a3b00ada611ba"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
