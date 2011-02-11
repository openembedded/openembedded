require sqlite3.inc
PR = "${INC_PR}.0"

EFAULT_PREFERENCE = "-1"

DEPENDS_virtclass-native = "readline-native ncurses-native"

SRC_URI[md5sum] = "5437978aae90350cf984993091e0d695"
SRC_URI[sha256sum] = "dbf352e8fbb74829f5e7a88f9f6ceeb80a709537f668c36e4b6cdfb271309ef6"

BBCLASSEXTEND = "native"
