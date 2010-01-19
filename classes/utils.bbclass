def subprocess_setup():
   import signal
   # Python installs a SIGPIPE handler by default. This is usually not what
   # non-Python subprocesses expect.
   signal.signal(signal.SIGPIPE, signal.SIG_DFL)

def oe_popen(d, cmd, **kwargs):
    """ Convenience function to call out processes with our exported
    variables in the environment.
    """
    from subprocess import Popen

    if kwargs.get("env") is None:
        env = d.getVar("__oe_popen_env", False)
        if env is None:
            env = {}
            for v in d.keys():
                if d.getVarFlag(v, "export"):
                    env[v] = d.getVar(v, True) or ""
            d.setVar("__oe_popen_env", env)
        kwargs["env"] = env

    kwargs["preexec_fn"] = subprocess_setup

    return Popen(cmd, **kwargs)

def oe_system(d, cmd):
    """ Popen based version of os.system. """
    return oe_popen(d, cmd, shell=True).wait()

# like os.path.join but doesn't treat absolute RHS specially
def base_path_join(a, *p):
    path = a
    for b in p:
        if path == '' or path.endswith('/'):
            path +=  b
        else:
            path += '/' + b
    return path

def base_path_relative(src, dest):
    """ Return a relative path from src to dest.

    >>> base_path_relative("/usr/bin", "/tmp/foo/bar")
    ../../tmp/foo/bar

    >>> base_path_relative("/usr/bin", "/usr/lib")
    ../lib

    >>> base_path_relative("/tmp", "/tmp/foo/bar")
    foo/bar
    """
    from os.path import sep, pardir, normpath, commonprefix

    destlist = normpath(dest).split(sep)
    srclist = normpath(src).split(sep)

    # Find common section of the path
    common = commonprefix([destlist, srclist])
    commonlen = len(common)

    # Climb back to the point where they differentiate
    relpath = [ pardir ] * (len(srclist) - commonlen)
    if commonlen < len(destlist):
        # Add remaining portion
        relpath += destlist[commonlen:]

    return sep.join(relpath)

def base_path_out(path, d):
    """ Prepare a path for display to the user. """
    rel = base_path_relative(d.getVar("TOPDIR", 1), path)
    if len(rel) > len(path):
        return path
    else:
        return rel

# for MD5/SHA handling
def base_chk_load_parser(config_paths):
    import ConfigParser
    parser = ConfigParser.ConfigParser()
    if len(parser.read(config_paths)) < 1:
        raise ValueError("no ini files could be found")

    return parser

def base_chk_file_vars(parser, localpath, params, data):
    try:
        name = params["name"]
    except KeyError:
        return False
    if name:
        md5flag = "%s.md5sum" % name
        sha256flag = "%s.sha256sum" % name
    else:
        md5flag = "md5sum"
        sha256flag = "sha256sum"
    want_md5sum = bb.data.getVarFlag("SRC_URI", md5flag, data)
    want_sha256sum = bb.data.getVarFlag("SRC_URI", sha256flag, data)

    if (want_sha256sum == None and want_md5sum == None):
        # no checksums to check, nothing to do
        return False

    if not os.path.exists(localpath):
        localpath = base_path_out(localpath, data)
        bb.note("The localpath does not exist '%s'" % localpath)
        raise Exception("The path does not exist '%s'" % localpath)

    if want_md5sum:
        try:
	    md5pipe = os.popen('PATH=%s md5sum "%s"' % (bb.data.getVar('PATH', data, True), localpath))
            md5data = (md5pipe.readline().split() or [ "" ])[0]
            md5pipe.close()
        except OSError, e:
            raise Exception("Executing md5sum failed")
        if want_md5sum != md5data:
            bb.note("The MD5Sums did not match. Wanted: '%s' and Got: '%s'" % (want_md5sum, md5data))
            raise Exception("MD5 Sums do not match. Wanted: '%s' Got: '%s'" % (want_md5sum, md5data))

    if want_sha256sum:
        try:
            shapipe = os.popen('PATH=%s oe_sha256sum "%s"' % (bb.data.getVar('PATH', data, True), localpath))
            sha256data = (shapipe.readline().split() or [ "" ])[0]
            shapipe.close()
        except OSError, e:
            raise Exception("Executing shasum failed")
        if want_sha256sum != sha256data:
            bb.note("The SHA256Sums did not match. Wanted: '%s' and Got: '%s'" % (want_sha256sum, sha256data))
            raise Exception("SHA256 Sums do not match. Wanted: '%s' Got: '%s'" % (want_sha256sum, sha256data))

    return True


def base_chk_file(parser, pn, pv, src_uri, localpath, data):
    no_checksum = False
    # Try PN-PV-SRC_URI first and then try PN-SRC_URI
    # we rely on the get method to create errors
    pn_pv_src = "%s-%s-%s" % (pn,pv,src_uri)
    pn_src    = "%s-%s" % (pn,src_uri)
    if parser.has_section(pn_pv_src):
        md5    = parser.get(pn_pv_src, "md5")
        sha256 = parser.get(pn_pv_src, "sha256")
    elif parser.has_section(pn_src):
        md5    = parser.get(pn_src, "md5")
        sha256 = parser.get(pn_src, "sha256")
    elif parser.has_section(src_uri):
        md5    = parser.get(src_uri, "md5")
        sha256 = parser.get(src_uri, "sha256")
    else:
        no_checksum = True

    # md5 and sha256 should be valid now
    if not os.path.exists(localpath):
        localpath = base_path_out(localpath, data)
        bb.note("The localpath does not exist '%s'" % localpath)
        raise Exception("The path does not exist '%s'" % localpath)


    # call md5(sum) and shasum
    try:
	md5pipe = os.popen('PATH=%s md5sum "%s"' % (bb.data.getVar('PATH', data, True), localpath))
        md5data = (md5pipe.readline().split() or [ "" ])[0]
        md5pipe.close()
    except OSError:
        raise Exception("Executing md5sum failed")

    try:
        shapipe = os.popen('PATH=%s oe_sha256sum "%s"' % (bb.data.getVar('PATH', data, True), localpath))
        shadata = (shapipe.readline().split() or [ "" ])[0]
        shapipe.close()
    except OSError:
        raise Exception("Executing shasum failed")

    if no_checksum == True:	# we do not have conf/checksums.ini entry
        try:
            file = open("%s/checksums.ini" % bb.data.getVar("TMPDIR", data, 1), "a")
        except:
            return False

        if not file:
            raise Exception("Creating checksums.ini failed")
        
        file.write("[%s]\nmd5=%s\nsha256=%s\n\n" % (src_uri, md5data, shadata))
        file.close()

        from string import maketrans
        trtable = maketrans("", "")
        uname = src_uri.split("/")[-1].translate(trtable, "-+._")

        try:
            ufile = open("%s/%s.sum" % (bb.data.getVar("TMPDIR", data, 1), uname), "wt")
        except:
            return False

        if not ufile:
            raise Exception("Creating %s.sum failed" % uname)

        ufile.write("SRC_URI = \"%s;name=%s\"\nSRC_URI[%s.md5sum] = \"%s\"\nSRC_URI[%s.sha256sum] = \"%s\"\n" % (src_uri, uname, uname, md5data, uname, shadata))
        ufile.close()

        if not bb.data.getVar("OE_STRICT_CHECKSUMS",data, True):
            bb.note("This package has no entry in checksums.ini, please add one")
            bb.note("\n[%s]\nmd5=%s\nsha256=%s" % (src_uri, md5data, shadata))
            bb.note("This package has no checksums in corresponding recipe, please add")
            bb.note("SRC_URI = \"%s;name=%s\"\nSRC_URI[%s.md5sum] = \"%s\"\nSRC_URI[%s.sha256sum] = \"%s\"\n" % (src_uri, uname, uname, md5data, uname, shadata))
            return True
        else:
            bb.note("Missing checksum")
            return False

    if not md5 == md5data:
        bb.note("The MD5Sums did not match. Wanted: '%s' and Got: '%s'" % (md5,md5data))
        raise Exception("MD5 Sums do not match. Wanted: '%s' Got: '%s'" % (md5, md5data))

    if not sha256 == shadata:
        bb.note("The SHA256 Sums do not match. Wanted: '%s' Got: '%s'" % (sha256,shadata))
        raise Exception("SHA256 Sums do not match. Wanted: '%s' Got: '%s'" % (sha256, shadata))

    return True

def base_read_file(filename):
	try:
		f = file( filename, "r" )
	except IOError, reason:
		return "" # WARNING: can't raise an error now because of the new RDEPENDS handling. This is a bit ugly. :M:
	else:
		return f.read().strip()
	return None

def base_ifelse(condition, iftrue = True, iffalse = False):
    if condition:
        return iftrue
    else:
        return iffalse

def base_conditional(variable, checkvalue, truevalue, falsevalue, d):
	if bb.data.getVar(variable,d,1) == checkvalue:
		return truevalue
	else:
		return falsevalue

def base_less_or_equal(variable, checkvalue, truevalue, falsevalue, d):
	if float(bb.data.getVar(variable,d,1)) <= float(checkvalue):
		return truevalue
	else:
		return falsevalue

def base_version_less_or_equal(variable, checkvalue, truevalue, falsevalue, d):
    result = bb.vercmp(bb.data.getVar(variable,d,True), checkvalue)
    if result <= 0:
        return truevalue
    else:
        return falsevalue

def base_contains(variable, checkvalues, truevalue, falsevalue, d):
	val = bb.data.getVar(variable,d,1)
	if not val:
		return falsevalue
	matches = 0
	if type(checkvalues).__name__ == "str":
		checkvalues = [checkvalues]
	for value in checkvalues:
		if val.find(value) != -1:
			matches = matches + 1
	if matches == len(checkvalues):
		return truevalue
	return falsevalue

def base_both_contain(variable1, variable2, checkvalue, d):
       if bb.data.getVar(variable1,d,1).find(checkvalue) != -1 and bb.data.getVar(variable2,d,1).find(checkvalue) != -1:
               return checkvalue
       else:
               return ""

def base_prune_suffix(var, suffixes, d):
    # See if var ends with any of the suffixes listed and 
    # remove it if found
    for suffix in suffixes:
        if var.endswith(suffix):
            return var.replace(suffix, "")
    return var

def oe_filter(f, str, d):
	from re import match
	return " ".join(filter(lambda x: match(f, x, 0), str.split()))

def oe_filter_out(f, str, d):
	from re import match
	return " ".join(filter(lambda x: not match(f, x, 0), str.split()))

oedebug() {
	test $# -ge 2 || {
		echo "Usage: oedebug level \"message\""
		exit 1
	}

	test ${OEDEBUG:-0} -ge $1 && {
		shift
		echo "DEBUG:" $*
	}
}

oe_soinstall() {
	# Purpose: Install shared library file and
	#          create the necessary links
	# Example:
	#
	# oe_
	#
	#oenote installing shared library $1 to $2
	#
	libname=`basename $1`
	install -m 755 $1 $2/$libname
	sonamelink=`${HOST_PREFIX}readelf -d $1 |grep 'Library soname:' |sed -e 's/.*\[\(.*\)\].*/\1/'`
	solink=`echo $libname | sed -e 's/\.so\..*/.so/'`
	ln -sf $libname $2/$sonamelink
	ln -sf $libname $2/$solink
}

oe_libinstall() {
	# Purpose: Install a library, in all its forms
	# Example
	#
	# oe_libinstall libltdl ${STAGING_LIBDIR}/
	# oe_libinstall -C src/libblah libblah ${D}/${libdir}/
	dir=""
	libtool=""
	silent=""
	require_static=""
	require_shared=""
	staging_install=""
	while [ "$#" -gt 0 ]; do
		case "$1" in
		-C)
			shift
			dir="$1"
			;;
		-s)
			silent=1
			;;
		-a)
			require_static=1
			;;
		-so)
			require_shared=1
			;;
		-*)
			oefatal "oe_libinstall: unknown option: $1"
			;;
		*)
			break;
			;;
		esac
		shift
	done

	libname="$1"
	shift
	destpath="$1"
	if [ -z "$destpath" ]; then
		oefatal "oe_libinstall: no destination path specified"
	fi
	if echo "$destpath/" | egrep '^${STAGING_LIBDIR}/' >/dev/null
	then
		staging_install=1
	fi

	__runcmd () {
		if [ -z "$silent" ]; then
			echo >&2 "oe_libinstall: $*"
		fi
		$*
	}

	if [ -z "$dir" ]; then
		dir=`pwd`
	fi

	dotlai=$libname.lai

	# Sanity check that the libname.lai is unique
	number_of_files=`(cd $dir; find . -name "$dotlai") | wc -l`
	if [ $number_of_files -gt 1 ]; then
		oefatal "oe_libinstall: $dotlai is not unique in $dir"
	fi


	dir=$dir`(cd $dir;find . -name "$dotlai") | sed "s/^\.//;s/\/$dotlai\$//;q"`
	olddir=`pwd`
	__runcmd cd $dir

	lafile=$libname.la

	# If such file doesn't exist, try to cut version suffix
	if [ ! -f "$lafile" ]; then
		libname1=`echo "$libname" | sed 's/-[0-9.]*$//'`
		lafile1=$libname.la
		if [ -f "$lafile1" ]; then
			libname=$libname1
			lafile=$lafile1
		fi
	fi

	if [ -f "$lafile" ]; then
		# libtool archive
		eval `cat $lafile|grep "^library_names="`
		libtool=1
	else
		library_names="$libname.so* $libname.dll.a"
	fi

	__runcmd install -d $destpath/
	dota=$libname.a
	if [ -f "$dota" -o -n "$require_static" ]; then
		__runcmd install -m 0644 $dota $destpath/
	fi
	if [ -f "$dotlai" -a -n "$libtool" ]; then
		if test -n "$staging_install"
		then
			# stop libtool using the final directory name for libraries
			# in staging:
			__runcmd rm -f $destpath/$libname.la
			__runcmd sed -e 's/^installed=yes$/installed=no/' \
				     -e '/^dependency_libs=/s,${WORKDIR}[[:alnum:]/\._+-]*/\([[:alnum:]\._+-]*\),${STAGING_LIBDIR}/\1,g' \
				     -e "/^dependency_libs=/s,\([[:space:]']\)${libdir},\1${STAGING_LIBDIR},g" \
				     $dotlai >$destpath/$libname.la
		else
			__runcmd install -m 0644 $dotlai $destpath/$libname.la
		fi
	fi

	for name in $library_names; do
		files=`eval echo $name`
		for f in $files; do
			if [ ! -e "$f" ]; then
				if [ -n "$libtool" ]; then
					oefatal "oe_libinstall: $dir/$f not found."
				fi
			elif [ -L "$f" ]; then
				__runcmd cp -P "$f" $destpath/
			elif [ ! -L "$f" ]; then
				libfile="$f"
				__runcmd install -m 0755 $libfile $destpath/
			fi
		done
	done

	if [ -z "$libfile" ]; then
		if  [ -n "$require_shared" ]; then
			oefatal "oe_libinstall: unable to locate shared library"
		fi
	elif [ -z "$libtool" ]; then
		# special case hack for non-libtool .so.#.#.# links
		baselibfile=`basename "$libfile"`
		if (echo $baselibfile | grep -qE '^lib.*\.so\.[0-9.]*$'); then
			sonamelink=`${HOST_PREFIX}readelf -d $libfile |grep 'Library soname:' |sed -e 's/.*\[\(.*\)\].*/\1/'`
			solink=`echo $baselibfile | sed -e 's/\.so\..*/.so/'`
			if [ -n "$sonamelink" -a x"$baselibfile" != x"$sonamelink" ]; then
				__runcmd ln -sf $baselibfile $destpath/$sonamelink
			fi
			__runcmd ln -sf $baselibfile $destpath/$solink
		fi
	fi

	__runcmd cd "$olddir"
}

oe_machinstall() {
	# Purpose: Install machine dependent files, if available
	#          If not available, check if there is a default
	#          If no default, just touch the destination
	# Example:
	#                $1  $2   $3         $4
	# oe_machinstall -m 0644 fstab ${D}/etc/fstab
	#
	# TODO: Check argument number?
	#
	filename=`basename $3`
	dirname=`dirname $3`

	for o in `echo ${OVERRIDES} | tr ':' ' '`; do
		if [ -e $dirname/$o/$filename ]; then
			oenote $dirname/$o/$filename present, installing to $4
			install $1 $2 $dirname/$o/$filename $4
			return
		fi
	done
#	oenote overrides specific file NOT present, trying default=$3...
	if [ -e $3 ]; then
		oenote $3 present, installing to $4
		install $1 $2 $3 $4
	else
		oenote $3 NOT present, touching empty $4
		touch $4
	fi
}

def check_app_exists(app, d):
	from bb import which, data

	app = data.expand(app, d)
	path = data.getVar('PATH', d, 1)
	return len(which(path, app)) != 0

def explode_deps(s):
	return bb.utils.explode_deps(s)

def base_set_filespath(path, d):
	bb.note("base_set_filespath usage is deprecated, %s should be fixed" % d.getVar("P", 1))
	filespath = []
	# The ":" ensures we have an 'empty' override
	overrides = (bb.data.getVar("OVERRIDES", d, 1) or "") + ":"
	for p in path:
		for o in overrides.split(":"):
			filespath.append(os.path.join(p, o))
	return ":".join(filespath)
