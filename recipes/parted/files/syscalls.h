/*
 *  linux/include/asm-arm/unistd.h
 *
 *  Copyright (C) 2001-2005 Russell King
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as
 * published by the Free Software Foundation.
 *
 * Please forward _all_ changes to this file to rmk@arm.linux.org.uk,
 * no matter what the change is.  Thanks!
 */
#ifndef __ASM_ARM_UNISTD_H2
#define __ASM_ARM_UNISTD_H2


#define __sys2(x) #x
#define __sys1(x) __sys2(x)

#ifndef __syscall
#if defined(__thumb__) || defined(__ARM_EABI__)
#define __SYS_REG(name) register long __sysreg __asm__("r7") = __NR_##name;
#define __SYS_REG_LIST(regs...) "r" (__sysreg) , ##regs
#define __syscall(name) "swi\t0"
#else
#define __SYS_REG(name)
#define __SYS_REG_LIST(regs...) regs
#define __syscall(name) "swi\t" __sys1(__NR_##name) ""
#endif
#endif

#define __syscall_return(type, res)					\
do {									\
	if ((unsigned long)(res) >= (unsigned long)(-129)) {		\
		errno = -(res);						\
		res = -1;						\
	}								\
	return (type) (res);						\
} while (0)

#define _syscall0(type,name)						\
type name(void) {							\
  __SYS_REG(name)							\
  register long __res_r0 __asm__("r0");					\
  long __res;								\
  __asm__ __volatile__ (						\
  __syscall(name)							\
	: "=r" (__res_r0)						\
	: __SYS_REG_LIST() );						\
  __res = __res_r0;							\
  __syscall_return(type,__res);						\
}

#define _syscall1(type,name,type1,arg1) 				\
type name(type1 arg1) { 						\
  __SYS_REG(name)							\
  register long __r0 __asm__("r0") = (long)arg1;			\
  register long __res_r0 __asm__("r0");					\
  long __res;								\
  __asm__ __volatile__ (						\
  __syscall(name)							\
	: "=r" (__res_r0)						\
	: __SYS_REG_LIST( "0" (__r0) ) );				\
  __res = __res_r0;							\
  __syscall_return(type,__res);						\
}

#define _syscall2(type,name,type1,arg1,type2,arg2)			\
type name(type1 arg1,type2 arg2) {					\
  __SYS_REG(name)							\
  register long __r0 __asm__("r0") = (long)arg1;			\
  register long __r1 __asm__("r1") = (long)arg2;			\
  register long __res_r0 __asm__("r0");					\
  long __res;								\
  __asm__ __volatile__ (						\
  __syscall(name)							\
	: "=r" (__res_r0)						\
	: __SYS_REG_LIST( "0" (__r0), "r" (__r1) ) );			\
  __res = __res_r0;							\
  __syscall_return(type,__res);						\
}


#define _syscall3(type,name,type1,arg1,type2,arg2,type3,arg3)		\
type name(type1 arg1,type2 arg2,type3 arg3) {				\
  __SYS_REG(name)							\
  register long __r0 __asm__("r0") = (long)arg1;			\
  register long __r1 __asm__("r1") = (long)arg2;			\
  register long __r2 __asm__("r2") = (long)arg3;			\
  register long __res_r0 __asm__("r0");					\
  long __res;								\
  __asm__ __volatile__ (						\
  __syscall(name)							\
	: "=r" (__res_r0)						\
	: __SYS_REG_LIST( "0" (__r0), "r" (__r1), "r" (__r2) ) );	\
  __res = __res_r0;							\
  __syscall_return(type,__res);						\
}


#define _syscall4(type,name,type1,arg1,type2,arg2,type3,arg3,type4,arg4)\
type name(type1 arg1, type2 arg2, type3 arg3, type4 arg4) {		\
  __SYS_REG(name)							\
  register long __r0 __asm__("r0") = (long)arg1;			\
  register long __r1 __asm__("r1") = (long)arg2;			\
  register long __r2 __asm__("r2") = (long)arg3;			\
  register long __r3 __asm__("r3") = (long)arg4;			\
  register long __res_r0 __asm__("r0");					\
  long __res;								\
  __asm__ __volatile__ (						\
  __syscall(name)							\
	: "=r" (__res_r0)						\
	: __SYS_REG_LIST( "0" (__r0), "r" (__r1), "r" (__r2), "r" (__r3) ) ); \
  __res = __res_r0;							\
  __syscall_return(type,__res);						\
}
  

#define _syscall5(type,name,type1,arg1,type2,arg2,type3,arg3,type4,arg4,type5,arg5)	\
type name(type1 arg1, type2 arg2, type3 arg3, type4 arg4, type5 arg5) {	\
  __SYS_REG(name)							\
  register long __r0 __asm__("r0") = (long)arg1;			\
  register long __r1 __asm__("r1") = (long)arg2;			\
  register long __r2 __asm__("r2") = (long)arg3;			\
  register long __r3 __asm__("r3") = (long)arg4;			\
  register long __r4 __asm__("r4") = (long)arg5;			\
  register long __res_r0 __asm__("r0");					\
  long __res;								\
  __asm__ __volatile__ (						\
  __syscall(name)							\
	: "=r" (__res_r0)						\
	: __SYS_REG_LIST( "0" (__r0), "r" (__r1), "r" (__r2),		\
			  "r" (__r3), "r" (__r4) ) );			\
  __res = __res_r0;							\
  __syscall_return(type,__res);						\
}

#define _syscall6(type,name,type1,arg1,type2,arg2,type3,arg3,type4,arg4,type5,arg5,type6,arg6)	\
type name(type1 arg1, type2 arg2, type3 arg3, type4 arg4, type5 arg5, type6 arg6) {	\
  __SYS_REG(name)							\
  register long __r0 __asm__("r0") = (long)arg1;			\
  register long __r1 __asm__("r1") = (long)arg2;			\
  register long __r2 __asm__("r2") = (long)arg3;			\
  register long __r3 __asm__("r3") = (long)arg4;			\
  register long __r4 __asm__("r4") = (long)arg5;			\
  register long __r5 __asm__("r5") = (long)arg6;			\
  register long __res_r0 __asm__("r0");					\
  long __res;								\
  __asm__ __volatile__ (						\
  __syscall(name)							\
	: "=r" (__res_r0)						\
	: __SYS_REG_LIST( "0" (__r0), "r" (__r1), "r" (__r2),		\
			  "r" (__r3), "r" (__r4), "r" (__r5) ) );	\
  __res = __res_r0;							\
  __syscall_return(type,__res);						\
}

/*
 * "Conditional" syscalls
 *
 * What we want is __attribute__((weak,alias("sys_ni_syscall"))),
 * but it doesn't work on all toolchains, so we just do it by hand
 */
#define cond_syscall(x) asm(".weak\t" #x "\n\t.set\t" #x ",sys_ni_syscall")

#endif /* __ASM_ARM_UNISTD_H2 */
