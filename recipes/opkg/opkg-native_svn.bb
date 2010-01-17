require opkg.inc

DEPENDS = "curl-native openssl-native"
PR = "${INC_PR}"
PROVIDES =+ "virtual/update-alternatives-native"

SRC_URI += "file://opkg-libdir.patch;patch=1;maxrev=342"

target_libdir := "${libdir}"

inherit native

# The nogpg version isn't getting much love and has an unused variable which trips up -Werror
do_configure_prepend() {
        sed -i -e s:-Werror::g ${S}/libopkg/Makefile.am
}


EXTRA_OECONF += "--with-opkglibdir=${target_libdir} --disable-gpg"
