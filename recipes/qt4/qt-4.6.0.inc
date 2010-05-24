DEFAULT_PREFERENCE = "-1"

FILESPATHPKG .= ":qt-${PV}"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
           file://0001-cross-compile.patch \
           file://0002-fix-resinit-declaration.patch \
           file://0004-no-qmake.patch \
           file://0006-freetype-host-includes.patch \
           file://0008-qt-lib-infix.patch \
           file://0009-support-2bpp.patch \
           file://0010-no-simpledecoration-example.patch \
           file://fix-config-tests.patch \
           file://g++.conf \
           file://linux.conf \
           "

# Patches for '4.6' qt branch
SRC_URI += "\
           file://0860-Added-caching-of-vectorpaths-to-the-GL-paint-engine.patch \
           file://0917-Better-check-for-EGL-extension-strings.patch \
           file://0919-Rebind-window-surface-fbo-after-native-GL-rendering.patch \
           file://0943-Fixed-OpenGL-graphicssystem-issues-for-OpenGL-ES-2.0.patch \
           file://0945-Add-EGL_BUFFER_SIZE-to-QEglProperties-reduceConfigur.patch \
           file://0946-Fix-WA_TranslucentBackground-for-QGLWidgets-on-X11-E.patch \
           file://0947-Compressed-texture-binding-for-QtOpenGL-ETC1-and-PVR.patch \
           file://0951-Detect-GL2-paint-engine-based-on-fragment-shaders-no.patch \
           file://0971-Fix-GL_BGRA-formats-under-OpenGL-ES-systems.patch \
           file://0991-QGtkStyle-support-for-the-inner-border-property-in-G.patch \
           file://0992-Make-sure-a-context-is-current-when-loading-compress.patch \
           file://0993-Fix-upside-down-PVR-compressed-textures.patch \
           file://0996-Export-QGLShareRegister-because-qgl_share_reg-is-exp.patch \
           file://0998-Set-stacking-class-for-stays-on-top-windows-in-DFB.patch \
           file://0999-Enable-customizing-of-DirectFB-layer-to-use.patch \
           file://1008-GLES-2-should-not-use-a-multisampled-format-by-defau.patch \
           file://1115-Fix-QGLWidgets-created-with-an-alpha-channel-on-X11-.patch \
           file://1118-Fix-EGL-surface-leaks-when-re-parenting-QGLWidget-on.patch \
           file://1136-Disable-depth-testing-during-the-2D-QGLWidget-render.patch \
           file://1149-GL2Engine-Don-t-mark-brush-as-dirty-if-it-hasn-t-cha.patch \
           file://1157-Align-GL_RGB-lines-on-a-4-byte-boundary-when-uploadi.patch \
#           file://1165-NEON-configure-detection-and-initial-blend-function-.patch \
           file://1175-Fix-memory-leak-of-QGLGlyphCoord-objects-in-the-Open.patch \
           file://1197-Add-GLfloat-2-2-GLfloat-3-3-uniform-setters-to-QGLSh.patch \
           file://1198-Handle-broken-shaders-better-in-the-GL2-engine-s-sha.patch \
           file://1205-Fix-text-rendering-on-GL2-paint-engine.patch \
"

S = "${WORKDIR}/qt-everywhere-opensource-src-${PV}"

do_configure_prepend() {
    sed -i s:SEDME:${S}: ${WORKDIR}/linux.conf
    sed -i \
    -e /QMAKE_MOC\ /d \
    -e /QMAKE_UIC\ /d \
    -e /QMAKE_UIC3\ /d \
    -e /QMAKE_RCC\ /d \
    ${S}/configure
}

QT_GLFLAGS ?= ""
QT_CONFIG_FLAGS += "${QT_GLFLAGS}"

do_compile() {
    unset CFLAGS CXXFLAGS
    oe_runmake ${EXTRA_ENV}
}

do_install_append() {
	install -d ${D}${bindir}
	for i in rcc uic moc ; do
		install -m 0755 ${S}/bin/$i ${D}${bindir}/
	done
}

LICENSE = "LGPLv2.1 GPLv3"
SRC_URI += " \
            file://hack-out-pg_config.patch"

SRC_URI[md5sum] = "2a7b5126f2450d8525af355fc4c12ad6"
SRC_URI[sha256sum] = "55259c813324f6383cbd441aa2f23e01c320b6d63fbe3b5d52a7715055d28589"
