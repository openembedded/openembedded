DEFAULT_PREFERENCE = "-1"

FILESPATHPKG .= ":qt-${PV}"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
           file://0001-cross-compile.patch;patch=1 \
           file://0002-fix-resinit-declaration.patch;patch=1 \
           file://0004-no-qmake.patch;patch=1 \
           file://0006-freetype-host-includes.patch;patch=1 \
           file://0008-qt-lib-infix.patch;patch=1 \
           file://0009-support-2bpp.patch;patch=1 \
           file://0010-no-simpledecoration-example.patch;patch=1 \
           file://fix-config-tests.patch;patch=1 \
           file://g++.conf \
           file://linux.conf \
           "

# Patches for '4.6' qt branch
SRC_URI += "\
           file://0860-Added-caching-of-vectorpaths-to-the-GL-paint-engine.patch;patch=1 \
           file://0917-Better-check-for-EGL-extension-strings.patch;patch=1 \
           file://0919-Rebind-window-surface-fbo-after-native-GL-rendering.patch;patch=1 \
           file://0943-Fixed-OpenGL-graphicssystem-issues-for-OpenGL-ES-2.0.patch;patch=1 \
           file://0945-Add-EGL_BUFFER_SIZE-to-QEglProperties-reduceConfigur.patch;patch=1 \
           file://0946-Fix-WA_TranslucentBackground-for-QGLWidgets-on-X11-E.patch;patch=1 \
           file://0947-Compressed-texture-binding-for-QtOpenGL-ETC1-and-PVR.patch;patch=1 \
           file://0951-Detect-GL2-paint-engine-based-on-fragment-shaders-no.patch;patch=1 \
           file://0971-Fix-GL_BGRA-formats-under-OpenGL-ES-systems.patch;patch=1 \
           file://0991-QGtkStyle-support-for-the-inner-border-property-in-G.patch;patch=1 \
           file://0992-Make-sure-a-context-is-current-when-loading-compress.patch;patch=1 \
           file://0993-Fix-upside-down-PVR-compressed-textures.patch;patch=1 \
           file://0996-Export-QGLShareRegister-because-qgl_share_reg-is-exp.patch;patch=1 \
           file://0998-Set-stacking-class-for-stays-on-top-windows-in-DFB.patch;patch=1 \
           file://0999-Enable-customizing-of-DirectFB-layer-to-use.patch;patch=1 \
           file://1008-GLES-2-should-not-use-a-multisampled-format-by-defau.patch;patch=1 \
           file://1115-Fix-QGLWidgets-created-with-an-alpha-channel-on-X11-.patch;patch=1 \
           file://1118-Fix-EGL-surface-leaks-when-re-parenting-QGLWidget-on.patch;patch=1 \
           file://1136-Disable-depth-testing-during-the-2D-QGLWidget-render.patch;patch=1 \
           file://1149-GL2Engine-Don-t-mark-brush-as-dirty-if-it-hasn-t-cha.patch;patch=1 \
           file://1157-Align-GL_RGB-lines-on-a-4-byte-boundary-when-uploadi.patch;patch=1 \
#           file://1165-NEON-configure-detection-and-initial-blend-function-.patch;patch=1 \
           file://1175-Fix-memory-leak-of-QGLGlyphCoord-objects-in-the-Open.patch;patch=1 \
           file://1197-Add-GLfloat-2-2-GLfloat-3-3-uniform-setters-to-QGLSh.patch;patch=1 \
           file://1198-Handle-broken-shaders-better-in-the-GL2-engine-s-sha.patch;patch=1 \
           file://1205-Fix-text-rendering-on-GL2-paint-engine.patch;patch=1 \
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
            file://hack-out-pg_config.patch;patch=1"
