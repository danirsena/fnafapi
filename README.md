# 🎪 FNaF API

> Uma API simples inspirada na série **Five Nights at Freddy's**.  
> Fornece informações detalhadas sobre animatronics, jogos e lore da franquia.  
> Dados retirados do [FNaF Wiki](https://five-nights-at-freddy.fandom.com/wiki/Five_Nights_at_Freddy%27s_Wiki).

---

## ⚡ Funcionalidades

- Obtenha todos os animatronics de um jogo específico  
- Filtre por tipos (Rockstars, Mediocre Melodies, Scraps…)  
- Informações detalhadas: nome, id, fotos, e mais  
- Estrutura pronta para ser consumida em **web apps**, **bots** e **projetos pessoais**

---

## 🔗 Endpoints Principais

| Endpoint                   | Método | Descrição                                      |
|-----------------------------|--------|-----------------------------------------------|
| `https://apifnaf-site.onrender.com/apiFNAF/animatronics`             | GET    | Retorna todos os animatronics                 |
| `https://apifnaf-site.onrender.com/apiFNAF/animatronics/{id}`        | GET    | Retorna animatronic específico                |
| `https://apifnaf-site.onrender.com/apiFNAF/games`                    | GET    | Retorna lista de jogos da franquia            |
| `https://apifnaf-site.onrender.com/apiFNAF/games/{id}`               | GET    | Retorna animatronics de um jogo específico    |

---

## 💀 Exemplo de Uso

```javascript
// Puxando os animatronics de FNaF 6
fetch('https://apifnaf-site.onrender.com/apiFNAF/animatronics')
  .then(res => res.json())
  .then(data => {
    console.log('Animatronics disponíveis:', data);
  })
  .catch(err => console.error('Erro ao buscar dados:', err));
