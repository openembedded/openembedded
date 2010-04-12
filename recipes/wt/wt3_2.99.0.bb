require wt3.inc

PR = "${INC_PR}.1"

SRC_URI += "file://src.patch;patch=1 \
           "

do_configure_append() {
        ${BUILD_CXX} ${BUILD_CXXFLAGS} -o src/filetostring src/web/skeleton/FileToString.C
}

SRC_URI[tarball.md5sum] = "3d35c181dfab7dfd3fe898738dffb421"
SRC_URI[tarball.sha256sum] = "64e6bd25d18e838e1c60693eccbd11926c65b228d6ac69c4dafc7ebe7341dbbf"
