require iqnotes.inc

PR = "r5"

SRC_URI = "http://www.vanille.de/mirror/iqnotes-2.0.2-src.tar.bz2 \
           file://md5.diff;patch=1 \
           file://qt2310-fontbug.patch;patch=1"

SRC_URI[md5sum] = "9d9504055b37247ece87b31895eb2e5b"
SRC_URI[sha256sum] = "27badd5d9f3167443099c6b6cf66b05b9e32cc71f03d692cff474c2279c4f4cd"
