require jamvm.inc

SRC_URI += "file://debian-jni.patch;patch=1;pnum=0"

PR = "r0"

do_configure_prepend() {
  # Replaces the placeholder OE_LIBDIR_JNI with the JNI library directory
  # configured in OE.
  sed -i -e "s|OE_LIBDIR_JNI|${libdir_jni}|" src/dll.c
}


SRC_URI[md5sum] = "2a564045670b459e9aed857b5f8a3391"
SRC_URI[sha256sum] = "76c976616d344a3b1abd8896be6610c4d97a58af6960e1bc2f442b774bdda839"
