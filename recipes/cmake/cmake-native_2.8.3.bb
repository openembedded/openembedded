inherit native
require cmake.inc

PR = "${INC_PR}.0"

SRC_URI[md5sum] = "a76a44b93acf5e3badda9de111385921"
SRC_URI[sha256sum] = "689ed02786b5cefa5515c7716784ee82a82e8ece6be5a3d629ac3cc0c05fc288"

do_configure_append () {
        sed -e 's/BUILD_CursesDialog:BOOL=ON/BUILD_CursesDialog:BOOL=OFF/' \
                -i CMakeCache.txt
}
