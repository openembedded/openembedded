require cmake.inc

inherit cmake

DEPENDS += "curl expat zlib"

SRC_URI += "file://dont-run-cross-binaries.patch"

# Strip ${prefix} from ${docdir}, set result into docdir_stripped
python () {
    prefix=bb.data.getVar("prefix", d, 1)
    docdir=bb.data.getVar("docdir", d, 1)

    if not docdir.startswith(prefix):
	raise bb.build.FuncFailed('docdir must contain prefix as its prefix')

    docdir_stripped = docdir[len(prefix):]
    if len(docdir_stripped) > 0 and docdir_stripped[0] == '/':
	docdir_stripped = docdir_stripped[1:]

    bb.data.setVar("docdir_stripped", docdir_stripped, d)
}

EXTRA_OECMAKE=" \
# Override default "doc" (this is relative to ${prefix})
    -DCMAKE_DOC_DIR=${docdir_stripped}/cmake-2.8 \
# Using system libs spares us some cmake cross trouble.
    -DCMAKE_USE_SYSTEM_LIBRARIES=1 \
# This is compiler & target dependant, but it seems cmake does not in fact use this value.
    -DKWSYS_CHAR_IS_SIGNED=1 \
# This disables large file support. Hopefully nobody processes >2G files on the target.
# If you want to enable this, add -DWKSYS_LFS_WORKS=1
    -DKWSYS_LFS_DISABLE=1 \
"

SRC_URI[md5sum] = "8c967d5264657a798f22ee23976ff0d9"
SRC_URI[sha256sum] = "766ff169af798599d7dd42e41e9f4533d73942a2bb928235115412dce5b81406"

FILES_${PN} += "${datadir}/cmake-2.8"

# The doc is quite... absent. Just the licensing information is there.
# Real doc was nuked by dont-run-cross-binaries.patch. Fixing the doc
# generation would be quite complicated, as cmake build process innovatively
# runs the generated binaries to extract help contained in them.
# -> Fixing this is probably not worth it.
FILES_${PN}-doc += "${docdir}/cmake-2.8"
