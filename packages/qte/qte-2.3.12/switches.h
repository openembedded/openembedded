/*
 *  linux/include/linux/switches.h
 *
 *  Copyright (C) 2000 John Dorsey
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License version 2 as
 *  published by the Free Software Foundation.
 *
 *  23 October 2000 - created.
 */

#if !defined(_LINUX_SWITCHES_H)
#define _LINUX_SWITCHES_H

#define SWITCHES_MASK_SIZE  (128)

typedef unsigned long switches_bitfield;

#define SWITCHES_BITS            (sizeof(switches_bitfield) * 8)
#define SWITCHES_NUM_FIELDS      (SWITCHES_MASK_SIZE /  SWITCHES_BITS)
#define SWITCHES_FIELD_SELECT(i) ((i) / SWITCHES_BITS)
#define SWITCHES_FIELD_MASK(i)   ((switches_bitfield)(1 << (i) % \
                                  SWITCHES_BITS))

typedef struct switches_mask_t {
	unsigned int count;
	switches_bitfield events[SWITCHES_NUM_FIELDS];
	switches_bitfield states[SWITCHES_NUM_FIELDS];
} switches_mask_t;

#define SWITCHES_ZERO(m) \
do { \
	unsigned int sz_i; \
	(m)->count = 0; \
	for(sz_i = 0; sz_i < SWITCHES_NUM_FIELDS; ++sz_i) \
		(m)->events[sz_i] = (m)->states[sz_i] = 0; \
} while (0)

/* `s' is the state of the switch, either 0 or non-zero: */
#define SWITCHES_SET(m, i, s) \
do { \
	((m)->events[SWITCHES_FIELD_SELECT((i))] |= \
         SWITCHES_FIELD_MASK((i))); \
	if(s) \
		((m)->states[SWITCHES_FIELD_SELECT((i))] |= \
                 SWITCHES_FIELD_MASK((i))); \
	else \
		((m)->states[SWITCHES_FIELD_SELECT((i))] &= \
                 ~SWITCHES_FIELD_MASK((i))); \
	++((m)->count); \
} while (0)

/* Should only use to clear an event set by SWITCHES_SET(): */
#define SWITCHES_CLEAR(m, i) \
do { \
	((m)->events[SWITCHES_FIELD_SELECT((i))] &= \
         ~SWITCHES_FIELD_MASK((i))); \
	((m)->states[SWITCHES_FIELD_SELECT((i))] &= \
         ~SWITCHES_FIELD_MASK((i))); \
	--((m)->count); \
}

#define SWITCHES_COUNT(m) ((m)->count)

/* Returns 0 or non-zero: */
#define SWITCHES_EVENT(m, i) \
((m)->events[SWITCHES_FIELD_SELECT((i))] & SWITCHES_FIELD_MASK((i)))

/* Returns 0 or non-zero: */
#define SWITCHES_STATE(m, i) \
((m)->states[SWITCHES_FIELD_SELECT((i))] & SWITCHES_FIELD_MASK((i)))

#endif  /* !defined(_LINUX_SWITCHES_H) */
