require bison.inc

PR = "${INCPR}.0"

# >> bison-2.3-r0: /usr/lib/liby.a
# That one is a special case: it wants to stay in the main bison package,
# since bison itself is a development tool.  I'm not sure why it is a
# static-only library; that might be an error.

FILES_${PN} += "${libdir}/liby.a"
