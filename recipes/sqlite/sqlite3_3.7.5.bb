require sqlite3.inc
PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.sqlite.org/sqlite-autoconf-3070500.tar.gz"

S = "${WORKDIR}/sqlite-autoconf-3070500"

SRC_URI[md5sum] = "a9604a82613ade2e7f4c303f233e477f"
SRC_URI[sha256sum] = "cb5b86926ec9f65882b2dddd244f2d620337d911ec73411863f77e48cf6a2f94"
