# require different version? really?
require libpixman_0.10.0.bb

inherit native

PROVIDES = "libpixman-native"

# at least replace checksums from 0.10.0
SRC_URI[md5sum] = "09357cc74975b01714e00c5899ea1881"
SRC_URI[sha256sum] = "2b16516ef147bb604e1cf50c883143a052a7ff92d2930b70e571da0603b7d9ce"
