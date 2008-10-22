DESCRIPTION = "Twisted is an event-driven networking framework written in Python and licensed under the LGPL. \
Twisted supports TCP, UDP, SSL/TLS, multicast, Unix sockets, a large number of protocols                   \
(including HTTP, NNTP, IMAP, SSH, IRC, FTP, and others), and much more."
HOMEPAGE = "http://www.twistedmatrix.com"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "r7"

SRC_URI = "http://tmrc.mit.edu/mirror/twisted/Twisted/2.5/Twisted-${PV}.tar.bz2 \
           file://remove-zope-check.patch;patch=1"

S = "${WORKDIR}/Twisted-${PV}"

inherit distutils

PACKAGES += "python-twisted-zsh python-twisted-test python-twisted-protocols \
             python-twisted-runner-dbg \
             python-twisted-bin  python-twisted-conch python-twisted-lore \
             python-twisted-mail python-twisted-names python-twisted-news python-twisted-runner \
             python-twisted-web  python-twisted-words python-twisted python-twisted-core \
             "

RDEPENDS = "python-core python-zopeinterface"
RDEPENDS_python-twisted += "python-twisted-bin python-twisted-conch python-twisted-core \
                            python-twisted-lore python-twisted-mail python-twisted-names \
                            python-twisted-news python-twisted-runner python-twisted-web \
                            python-twisted-words"


ALLOW_EMPTY = "1"
FILES_${PN} = ""
FILES_python-twisted = ""

FILES_python-twisted-test = " \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/python/web/test \
"

FILES_python-twisted-protocols = " \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/python/protocols/ \
"

FILES_python-twisted-zsh = " \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/python/zsh \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/python/zshcomp.* \
"

FILES_python-twisted-bin = " \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/protocols/_c_urlarg.so \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/spread/cBanana.so \
"

FILES_python-twisted-conch = " \
  ${bindir}/ckeygen \
  ${bindir}/tkconch \
  ${bindir}/conch \
  ${bindir}/conchftp \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_conch.py \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/conch  \
"

FILES_python-twisted-core = " \
${bindir}/manhole \
${bindir}/mktap \
${bindir}/twistd \
${bindir}/tap2deb \
${bindir}/tap2rpm \
${bindir}/tapconvert \
${bindir}/tkmktap \
${bindir}/trial \
${libdir}/${PYTHON_DIR}/site-packages/twisted/*.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/__init__.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/notestplugin.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/testplugin.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_ftp.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_inet.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_manhole.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_portforward.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_socks.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_telnet.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_trial.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/dropin.cache \
${libdir}/${PYTHON_DIR}/site-packages/twisted/application \
${libdir}/${PYTHON_DIR}/site-packages/twisted/cred \
${libdir}/${PYTHON_DIR}/site-packages/twisted/enterprise \
${libdir}/${PYTHON_DIR}/site-packages/twisted/internet \
${libdir}/${PYTHON_DIR}/site-packages/twisted/manhole \
${libdir}/${PYTHON_DIR}/site-packages/twisted/manhole \
${libdir}/${PYTHON_DIR}/site-packages/twisted/persisted \
${libdir}/${PYTHON_DIR}/site-packages/twisted/protocols\
${libdir}/${PYTHON_DIR}/site-packages/twisted/python\
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/timeoutqueue.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/filepath.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/dxprofile.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/plugin.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/htmlizer.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/__init__.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/dispatch.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/hook.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/threadpool.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/otp.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/usage.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/roots.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/versions.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/urlpath.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/util.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/components.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/logfile.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/runtime.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/reflect.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/context.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/threadable.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/rebuild.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/failure.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/lockfile.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/formmethod.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/finalize.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/win32.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/dist.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/shortcut.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/zipstream.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/release.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/syslog.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/log.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/compat.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/zshcomp.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/procutils.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/text.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/python/_twisted_zsh_stub \
${libdir}/${PYTHON_DIR}/site-packages/twisted/scripts/ \
${libdir}/${PYTHON_DIR}/site-packages/twisted/spread/ \
${libdir}/${PYTHON_DIR}/site-packages/twisted/tap/ \
${libdir}/${PYTHON_DIR}/site-packages/twisted/trial/ \
${libdir}/${PYTHON_DIR}/site-packages/twisted/__init__.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/_version.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/copyright.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/im.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugin.py \
"

FILES_python-twisted-lore = " \
${bindir}/bookify \
${bindir}/lore \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_lore.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/lore \
"

FILES_python-twisted-mail = " \
${bindir}/mailmail \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_mail.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/mail \
"

FILES_python-twisted-names = " \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_names.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/names \
"

FILES_python-twisted-news = " \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_news.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/news \
"

FILES_python-twisted-runner = " \
${libdir}/site-packages/twisted/runner/portmap.so \
${libdir}/${PYTHON_DIR}/site-packages/twisted/runner\
"

FILES_python-twisted-web = " \
${bindir}/websetroot \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_web.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/web\
"

FILES_python-twisted-words = " \
${bindir}/im \
${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_words.py \
${libdir}/${PYTHON_DIR}/site-packages/twisted/words\
"

FILES_python-twisted-runner-dbg += " \
${libdir}/${PYTHON_DIR}/site-packages/twisted/runner/.debug"

