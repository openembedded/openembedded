inherit native
require cmake.inc

PR = "r1"

SRC_URI[md5sum] = "8c967d5264657a798f22ee23976ff0d9"
SRC_URI[sha256sum] = "766ff169af798599d7dd42e41e9f4533d73942a2bb928235115412dce5b81406"

do_configure_append () {
        sed -e 's/BUILD_CursesDialog:BOOL=ON/BUILD_CursesDialog:BOOL=OFF/' \
                -i CMakeCache.txt
}
