DEPENDS += " cmake-native "

# We want the staging and installing functions from autotools
inherit autotools

cmake_do_configure() {
    cmake . -DCMAKE_INSTALL_PREFIX:PATH=${prefix}
}

EXPORT_FUNCTIONS do_configure
