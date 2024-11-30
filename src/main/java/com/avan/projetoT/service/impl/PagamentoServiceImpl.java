package com.avan.projetoT.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avan.projetoT.domain.FormaPagamento;
import com.avan.projetoT.domain.Pagamento;
import com.avan.projetoT.domain.Reserva;
import com.avan.projetoT.domain.ReservaStatus;
import com.avan.projetoT.repository.PagamentoRepository;
import com.avan.projetoT.repository.ReservaRepository;
import com.avan.projetoT.service.PagamentoService;

@Service
public class PagamentoServiceImpl implements PagamentoService{
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
    private ReservaRepository reservaRepository;

	@Override
	public Optional<Pagamento> criarPagamento(Long reservaId, Double valor, FormaPagamento formaPagamento) {
		Optional<Reserva> reservaOpt = reservaRepository.findById(reservaId);

        if (reservaOpt.isPresent()) {
            Pagamento pagamento = new Pagamento();
            pagamento.setValor(valor);
            pagamento.setDataPagamento(new Date());
            pagamento.setFormaPagamento(formaPagamento);
            pagamento.setReserva(reservaOpt.get());
            pagamento.getReserva().setStatus(ReservaStatus.CONFIRMADA);
            return Optional.of(pagamentoRepository.save(pagamento));
        }

        return Optional.empty();
	}

}
