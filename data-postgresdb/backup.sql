--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2022-03-13 20:32:01

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 218 (class 1259 OID 16480)
-- Name: id_comment_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.id_comment_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_comment_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 212 (class 1259 OID 16457)
-- Name: comments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comments (
    id_comment bigint DEFAULT nextval('public.id_comment_seq'::regclass) NOT NULL,
    id_user bigint,
    content_text text,
    content_image text,
    date_comment date
);


ALTER TABLE public.comments OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16479)
-- Name: id_friends_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.id_friends_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_friends_seq OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16468)
-- Name: friends; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.friends (
    id_friends bigint DEFAULT nextval('public.id_friends_seq'::regclass) NOT NULL,
    id_user_sender bigint,
    id_user_receptor bigint,
    date_request time with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    is_acepted boolean DEFAULT false NOT NULL
);


ALTER TABLE public.friends OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16478)
-- Name: id_post_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.id_post_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999999
    CACHE 1;


ALTER TABLE public.id_post_seq OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16477)
-- Name: id_profile_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.id_profile_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999999
    CACHE 1;


ALTER TABLE public.id_profile_seq OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16475)
-- Name: id_user_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.id_user_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_user_seq OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16441)
-- Name: post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.post (
    id_post bigint DEFAULT nextval('public.id_post_seq'::regclass) NOT NULL,
    id_user bigint,
    content_post text,
    date_post timestamp without time zone,
    num_likes smallint,
    num_comments smallint
);


ALTER TABLE public.post OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16450)
-- Name: profile; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profile (
    id_profile smallint DEFAULT nextval('public.id_profile_seq'::regclass) NOT NULL,
    name text,
    last_name text,
    age smallint,
    date_of_birth date,
    phone_number numeric,
    email text
);


ALTER TABLE public.profile OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16436)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id_user bigint DEFAULT nextval('public.id_user_seq'::regclass) NOT NULL,
    password text NOT NULL,
    user_name text NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 3343 (class 0 OID 16457)
-- Dependencies: 212
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.comments (id_comment, id_user, content_text, content_image, date_comment) FROM stdin;
2	1	Super, me gusto la info	carita feliz 09009.png	2022-03-11
3	1	x2 super bien	file23423.gif	2022-03-11
4	1	x3 super bien like xmil	file23423.gif	2022-03-11
\.


--
-- TOC entry 3344 (class 0 OID 16468)
-- Dependencies: 213
-- Data for Name: friends; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.friends (id_friends, id_user_sender, id_user_receptor, date_request, is_acepted) FROM stdin;
3	2	3	15:04:14.391-06	f
4	2	1	15:04:14.391-06	t
2	1	2	15:04:14.391929-06	f
\.


--
-- TOC entry 3341 (class 0 OID 16441)
-- Dependencies: 210
-- Data for Name: post; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.post (id_post, id_user, content_post, date_post, num_likes, num_comments) FROM stdin;
2	1	Nuevo post desde postman :)	2022-03-10 00:00:00	345	15
3	1	Otro post desde postman :)	2022-03-11 00:00:00	345	15
4	1	Otro post desde postman editadoo  8:53 okokoko	2022-03-11 08:53:52.181	345	15
\.


--
-- TOC entry 3342 (class 0 OID 16450)
-- Dependencies: 211
-- Data for Name: profile; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profile (id_profile, name, last_name, age, date_of_birth, phone_number, email) FROM stdin;
2	ana	barrera	25	2022-10-18	985365	ana@gmail.com
3	LULU	TORRES	50	2022-10-18	985365	lulut@gmail.com
1	maribel	barrera tabares	27	2022-10-18	123569874	maribel_barrera@gmail.com
\.


--
-- TOC entry 3340 (class 0 OID 16436)
-- Dependencies: 209
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id_user, password, user_name) FROM stdin;
2	ana	ana
1	123	marybel
4	toby	toby
5	mina	mina
\.


--
-- TOC entry 3360 (class 0 OID 0)
-- Dependencies: 218
-- Name: id_comment_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.id_comment_seq', 4, true);


--
-- TOC entry 3361 (class 0 OID 0)
-- Dependencies: 217
-- Name: id_friends_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.id_friends_seq', 4, true);


--
-- TOC entry 3362 (class 0 OID 0)
-- Dependencies: 216
-- Name: id_post_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.id_post_seq', 4, true);


--
-- TOC entry 3363 (class 0 OID 0)
-- Dependencies: 215
-- Name: id_profile_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.id_profile_seq', 4, true);


--
-- TOC entry 3364 (class 0 OID 0)
-- Dependencies: 214
-- Name: id_user_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.id_user_seq', 5, true);


--
-- TOC entry 3198 (class 2606 OID 16463)
-- Name: comments comments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comments
    ADD CONSTRAINT comments_pkey PRIMARY KEY (id_comment);


--
-- TOC entry 3200 (class 2606 OID 16474)
-- Name: friends friends_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.friends
    ADD CONSTRAINT friends_pkey PRIMARY KEY (id_friends);


--
-- TOC entry 3194 (class 2606 OID 16445)
-- Name: post post_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_pkey PRIMARY KEY (id_post);


--
-- TOC entry 3196 (class 2606 OID 16456)
-- Name: profile profile_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_pkey PRIMARY KEY (id_profile);


--
-- TOC entry 3192 (class 2606 OID 16447)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id_user);


--
-- TOC entry 3355 (class 0 OID 0)
-- Dependencies: 212
-- Name: TABLE comments; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.comments TO pg_database_owner;


--
-- TOC entry 3356 (class 0 OID 0)
-- Dependencies: 213
-- Name: TABLE friends; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.friends TO pg_database_owner;


--
-- TOC entry 3357 (class 0 OID 0)
-- Dependencies: 210
-- Name: TABLE post; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.post TO pg_database_owner;


--
-- TOC entry 3358 (class 0 OID 0)
-- Dependencies: 211
-- Name: TABLE profile; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.profile TO pg_database_owner;


--
-- TOC entry 3359 (class 0 OID 0)
-- Dependencies: 209
-- Name: TABLE users; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.users TO pg_database_owner;


-- Completed on 2022-03-13 20:32:01

--
-- PostgreSQL database dump complete
--

