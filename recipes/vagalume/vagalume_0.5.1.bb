DESCRIPTION = "Last.fm client"
AUTHOR = "agarcia@igalia.com"
HOMEPAGE = "http://people.igalia.com/berto/"
SECTION = "x11"
DEPENDS = "gtk+"
PR = "r1"

SRC_URI = "\
  http://people.igalia.com/berto/files/vagalume/source/vagalume_0.5.1-1.tar.gz \
  file://use-png-icons.patch;patch=1 \
"

inherit autotools

SRC_URI[md5sum] = "5ec548c343de435b94a7b39f5c853292"
SRC_URI[sha256sum] = "10263676cb872ca48d8d605be44eb1e6260419675409732e7e5a76eb41843cee"
