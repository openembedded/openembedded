require wt3.inc

PR = "${INC_PR}.1"

SRC_URI += "file://src.patch;patch=1 \
           "

do_configure_append() {
        ${BUILD_CXX} ${BUILD_CXXFLAGS} -o src/filetostring src/web/skeleton/FileToString.C
}
