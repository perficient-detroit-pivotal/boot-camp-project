/*
 * Author : Pratyusha Vankayala
 *  Pivotal Boot Camp - Perficient
 * 
 */
package com.perficient.spring.web.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perficient.spring.web.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

	Candidate findOne(int id);
	Candidate saveCandidate(Candidate c);
	Candidate addCandidate(Candidate c);
<<<<<<< HEAD
	Candidate convert(Candidate c);
=======
	ArrayList<String> findAll(String params);
>>>>>>> branch 'master' of https://github.com/perficient-detroit-pivotal/boot-camp-project.git
}
