#! /bin/bash

eval $(grep '^\(TESTPROGRAMS\|SUBDIRS\)=' runtests.sh)

FAILURES_BOGUS=(
  ":gethostbyname"		# network test; net might not be available in test environment
  ":gethostbyname_r"		# network test; net might not be available in test environment

  ":stdlib:tst-environ"		# test uses environ function in unsupported ways (dup keys)
  ":stdlib:tst-rand48"		# platform dependent; does not give reliable results
  ":stdlib:tst-strtod"		# infinite recursion in __dtostr()
  ":time:tst-mktime"		# dietlibc does not support $TZ env
  ":time:tst-posixtz"		# dietlibc does not support $TZ env
  ":time:tst-strftime"		# dietlibc does not support glibc specific format specifications
)

FAILURES_BOGUS_emulator=(
  ":adjtime"			# ajdtimex() not implement in qemu
  ":if_nameindex"		# ioctls not implement in qemu
  ":mmap_test"			# qemu does not pass back mmap(2) error codes
  ":fadvise"			# bad translation of 64bit args in qemu
  ":stdio:tst-fseek"		# !! unclear; must be investigated
)

FAILURES_KNOWN=(
  ":sendfile"			# stdin/stdout not supported; test must be wrapped
  ":stdio:tstdiomisc"		# scanf(3) fails on some constructs
  ":stdio:tst-fphex"		# printf(3) does not support %a specifiers
  ":stdio:tst-printf"		# printf(3) does not support some floating point ops
  ":stdio:tst-sscanf"		# scanf(3) fails on double input
  ":stdlib:test-canon"		# realpath(3) is broken...
)

function is_in() {
    local	val=$1
    local	i
    shift

    for i; do
	test x"$i" != x"$val" || return 0
    done
    return 1
}

rc=0

: ${EMULATOR:=}
: ${RUNTEST_INDENT=0}
export RUNTEST_INDENT
export RUNTEST_NS

test -z "$EMULATOR" || \
    FAILURES_BOGUS=( "${FAILURES_BOGUS[@]}" "${FAILURES_BOGUS_emulator[@]}" )

for p in $TESTPROGRAMS; do
    ! tty -s || printf '%*s%-20s' $RUNTEST_INDENT '' "$p"

    is_in "$RUNTEST_NS:$p" "${FAILURES_BOGUS[@]}" && fail_bogus=true || fail_bogus=false
    is_in "$RUNTEST_NS:$p" "${FAILURES_KNOWN[@]}" && fail_known=true || fail_known=false
    $EMULATOR ./$p >/dev/null && failed=false || failed=true

    case $failed:$fail_known:$fail_bogus in
      (false:false:*)		res='OK';;
      (false:true:true)		res='OK (bogus)';;
      (false:true:false)	res="OK (unexpected)"; let ++rc;;
      (true:*:true)		res='FAIL (bogus)';;
      (true:true:*)		res="FAIL (known)";;
      (true:false:*)		res='FAIL'; let ++rc;;
    esac

    ! tty -s || printf '\r'

    printf '%*s%-20s%s\n' $RUNTEST_INDENT '' "$p" "$res"
done

test $rc -eq 0 || \
    printf "%*s--> %u tests failed\n" $RUNTEST_INDENT '' $rc

for d in $SUBDIRS; do
    echo "--- entering directory $d ---"
    let RUNTEST_INDENT+=2
    old_ns=$RUNTEST_NS
    RUNTEST_NS=$RUNTEST_NS:$d

    cd $d && bash ./runtests-X.sh || let ++rc

    RUNTEST_NS=$old_ns
    let RUNTEST_INDENT-=2

    cd $OLDPWD || exit 1
done

test $rc -eq 0 && exit 0 || exit 1
